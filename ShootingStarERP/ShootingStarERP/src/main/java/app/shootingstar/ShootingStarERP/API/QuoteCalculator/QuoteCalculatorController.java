package app.shootingstar.ShootingStarERP.API.QuoteCalculator;


import app.shootingstar.ShootingStarERP.API.Mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quote_calculator")
@CrossOrigin("*")
public class QuoteCalculatorController {
    @Autowired
    private QuoteCalculatorRepository repo;
    private final EmailService emailService;

    QuoteCalculatorController(QuoteCalculatorRepository repository, EmailService emailService) {
        this.repo = repository;
        this.emailService = emailService;
    }

    @PostMapping
    public QuoteCalculator create(@RequestBody QuoteCalculator quoteCalculator) {
        this.emailService.sendQuoteMessage(quoteCalculator.toString());
        return repo.save(quoteCalculator);
    }


}
