package org.example.shopp.application.history;

import lombok.RequiredArgsConstructor;
import org.example.shopp.domain.entity.History;
import org.example.shopp.infrastructure.repository.HistoryRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepo historyRepository;

//    public History getCartHistory(Long cartId) {
//        return historyRepository.getCartHistory(cartId);
//    }
}
