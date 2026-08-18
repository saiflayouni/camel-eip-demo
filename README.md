# Apache Camel - Enterprise Integration Patterns

## Pattern 1: Content-Based Router (CBR)

Routes incoming orders to different destinations based on message content.

### How it works

### Route logic
- `widget + urgent` → `target/orders/widget-urgent/`
- `widget + normal` → `target/orders/widget-normal/`
- `gadget + urgent` → `target/orders/gadget-urgent/`
- `gadget + normal` → `target/orders/gadget-normal/`

### Run
```bash
mvn compile camel:run
```

### Equivalent in WSO2 MI
`<switch>` + `<property>` mediators

### Equivalent in Apigee
ExtractVariables policy + RouteRule conditions

## References
- [Enterprise Integration Patterns - Gregor Hohpe](https://www.eaipatterns.com)
- [Apache Camel Documentation](https://camel.apache.org)
