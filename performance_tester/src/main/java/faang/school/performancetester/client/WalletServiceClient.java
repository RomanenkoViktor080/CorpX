package faang.school.performancetester.client;

import faang.school.performancetester.dto.TransactionDto;
import faang.school.performancetester.dto.WalletDto;
import jakarta.validation.constraints.Min;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "RestApiWallet", url = "${wallet-service.host}:${wallet-service.port}")
public interface WalletServiceClient {
    @GetMapping("api/v1/wallet/{WALLET_UUID}")
    WalletDto getWalletBalance(@PathVariable UUID WALLET_UUID);

    @PostMapping("api/v1//wallet")
    void walletTransaction(@Validated @RequestBody TransactionDto transactionDto);
}
