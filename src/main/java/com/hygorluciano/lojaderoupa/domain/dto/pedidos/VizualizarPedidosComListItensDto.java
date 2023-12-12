package com.hygorluciano.lojaderoupa.domain.dto.pedidos;

import com.hygorluciano.lojaderoupa.domain.dto.detalhespedido.VerDetalhesPedido;
import com.hygorluciano.lojaderoupa.domain.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public record VizualizarPedidosComListItensDto(
        Long id_pedido,

        LocalDateTime data_do_pedido,
        Status status,
        double valor,
        String nome_do_usuario,
        List<VerDetalhesPedido> lista_itens
) {
}