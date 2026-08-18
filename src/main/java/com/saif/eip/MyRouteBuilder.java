package com.saif.eip;

import org.apache.camel.builder.RouteBuilder;


/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {
        from("file:src/orders?noop=true")
                .choice()
                .when(xpath("/order/type = 'widget'"))
                .log("→ Widget Inventory: ${body}")
                .when(xpath("/order/type = 'gadget'"))
                .log("→ Gadget Inventory: ${body}")
                .otherwise()
                        .log("→UNknown")
                .endChoice();

    }

}
