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
        errorHandler(deadLetterChannel("file:target/orders/failed"));

        /*
        from("file:src/orders?noop=true")
                .choice()
                /*
                .when(xpath("/order/type ='widget' and /order/priority = 'urgent'"))
                .log("→ URGENT Widget Order: ${body}")
                .to("file:target/orders/widget-urgent")
                //
                .when(xpath("/order/type ='widget' and /order/priority = 'normal'"))
                .log("→ NORMAL Widget Order: ${body}")
                .to("file:target/orders/widget-normal")
                //
                .when(xpath("/order/type ='gadget' and /order/priority = 'urgent'"))
                .log("→ URGENT gadget Order: ${body}")
                .to("file:target/orders/gadget-urgent")
                //
                .when(xpath("/order/type ='gadget' and /order/priority = 'normal'"))
                .log("→ NORMAL Widget Order: ${body}")
                .to("file:target/orders/gadget-normal")
                .otherwise()
                .log("→ Unknown order")
                .endChoice();
                */
            from("file:src/orders?noop=true")
                    .setHeader("type", xpath("/order/type/text()"))
                    .setHeader("priority", xpath("/order/priority/text()"))
                    .log("→ [${header.CamelFileName}] type: ${header.type} | priority: ${header.priority}")
                    .toD("file:target/orders/${header.type}-${header.priority}");


    }

}
