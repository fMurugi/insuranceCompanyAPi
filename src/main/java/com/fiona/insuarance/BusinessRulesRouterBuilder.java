//package com.fiona.insuarance;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.kie.KieComponent;
//import org.apache.camel.component.kie.KieConstants;
//
//public class BusinessRulesRouterBuilder extends RouteBuilder {
//    @Override
//    public void configure() throws Exception {
//        KieComponent kie = new KieComponent();
//        kie.setReleaseId("com.example:insurance-rules:1.0.0"); // specify the Maven GAV coordinates of the rules artifact
//        kie.setKieSessionName("QuotationSession"); // specify the name of the KieSession to use
//        kie.setKieBaseName("QuotationBase"); // specify the name of the KieBase to use
//        getContext().addComponent("kie", kie);
//    }
//}
