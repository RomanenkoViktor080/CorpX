package faang.school.performancetester.service;

import faang.school.performancetester.client.WalletServiceClient;
import faang.school.performancetester.dto.TransactionDto;
import faang.school.performancetester.entity.OperationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletService {
    private final WalletServiceClient walletServiceClient;

    public long sendTransactions(int number) {
        long startTime = System.currentTimeMillis();
        TransactionDto transactionDto = new TransactionDto(
                UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11"),
                OperationType.DEPOSIT,
                1);

        for(int i=0; i<number; i++) {
            walletServiceClient.walletTransaction(transactionDto);
        }
        return System.currentTimeMillis()-startTime;
    }
}
