package com.amigoscode;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudser(@PathVariable("customerId") Integer customerID) {

        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);

        log.info("Fraud check request for customer {}", customerID);
        return new FraudCheckResponse(isFraudulentCustomer);

    }


}
