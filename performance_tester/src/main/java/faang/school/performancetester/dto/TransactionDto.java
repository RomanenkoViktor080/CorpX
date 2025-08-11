package faang.school.performancetester.dto;

import faang.school.performancetester.entity.OperationType;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {
    private UUID walletId;
    private OperationType operationType;
    @Max(1000000000)
    private double amount;
}
