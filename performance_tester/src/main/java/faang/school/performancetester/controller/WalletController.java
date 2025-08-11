package faang.school.performancetester.controller;

import faang.school.performancetester.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/performance/wallet")
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/transaction/{number}")
    public long sendTransactions(@PathVariable int number) {
        return walletService.sendTransactions(number);
    }
}
