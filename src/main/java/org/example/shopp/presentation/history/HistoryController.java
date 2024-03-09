package org.example.shopp.presentation.history;

import lombok.AllArgsConstructor;
import org.example.shopp.infrastructure.routes.HistoryRoutes;
import org.example.shopp.presentation.history.dto.query.HistoryQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HistoryRoutes.HISTORY)
@AllArgsConstructor
public class HistoryController {

//    @GetMapping(HistoryRoutes.GET_CART_HISTORY)
//    public List<HistoryQuery> getCartHistory() {
//        return null;
//    }
}
