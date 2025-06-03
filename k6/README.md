# Testes de Performance com k6

Este diretório contém os testes de performance da aplicação utilizando o k6.

## Pré-requisitos

Você pode executar os testes de duas formas:

1. **Instalação Local do k6**:
   - Instalar o k6: https://k6.io/docs/getting-started/installation/

2. **Usando Docker Compose** (Recomendado):
   - Docker e Docker Compose instalados
   - Não é necessário instalar o k6 localmente

## Cenários de Teste

O script `performance-test.js` contém três cenários diferentes que são executados em sequência, totalizando aproximadamente 3 minutos:

1. **Smoke Test** (30 segundos):
   - 1 usuário constante
   - Verifica funcionalidade básica com carga mínima
   - Tempo de resposta esperado < 200ms

2. **Teste de Carga** (1.5 minutos):
   - Rampa até 50 usuários
   - Simula uso normal da aplicação
   - 3 estágios de 30 segundos cada:
     * 0 → 50 usuários
     * Mantém 50 usuários
     * 50 → 0 usuários
   - Tempo de resposta esperado < 500ms

3. **Teste de Stress** (1.5 minutos):
   - Rampa até 100 usuários
   - Testa os limites da aplicação
   - 3 estágios de 30 segundos cada:
     * 0 → 100 usuários
     * Mantém 100 usuários
     * 100 → 0 usuários

## Como Executar

### Usando Docker Compose (Recomendado)

1. Inicie todos os serviços:
   ```bash
   docker-compose up -d
   ```

2. Execute os testes:
   ```bash
   # Todos os cenários (aprox. 3 minutos)
   docker-compose run k6 run /scripts/performance-test.js

   # Cenário específico
   docker-compose run k6 run --only-scenario smoke /scripts/performance-test.js
   docker-compose run k6 run --only-scenario load /scripts/performance-test.js
   docker-compose run k6 run --only-scenario stress /scripts/performance-test.js
   ```

3. Visualize os resultados:
   - Abra o Grafana em `http://localhost:3000`
   - Os dashboards estarão disponíveis automaticamente

### Usando k6 Local

1. Certifique-se que sua aplicação está rodando em `http://localhost:8080`
   (ou ajuste a URL no arquivo `performance-test.js`)

2. Execute os testes:
   ```bash
   k6 run performance-test.js
   ```

## Métricas Monitoradas

- Taxa de erro (deve ser < 10%)
- Tempo de resposta (95% das requisições)
  - Smoke test: < 200ms
  - Testes de carga/stress: < 500ms
- Throughput
- Usuários virtuais ativos

## Visualização dos Resultados

### Com Docker Compose

1. Acesse o Grafana em `http://localhost:3000`
2. Os dados são automaticamente coletados no InfluxDB
3. Visualize em tempo real:
   - Tempo de resposta
   - Número de requisições por segundo
   - Taxa de erro
   - Usuários ativos
   - Uso de recursos do sistema

### Sem Docker Compose

Ao final da execução, o k6 fornecerá um relatório com as métricas coletadas no terminal.
Valores importantes a observar:

- `http_req_duration`: tempo de resposta das requisições
- `http_reqs`: número total de requisições
- `iterations`: número total de iterações completadas
- `vus`: usuários virtuais
- `errors`: taxa de erros

Se algum threshold for violado, o teste falhará, indicando que a performance 
não está dentro dos parâmetros esperados. 