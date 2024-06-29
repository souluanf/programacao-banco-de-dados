package dev.luanfernandes.pizzaria.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {
    private static final String API = "/api";

    public static final String CLIENTE_V1 = API + "/v1/clientes";
    public static final String CLIENTE_ID = CLIENTE_V1 + "/{clienteId}";

    public static final String ENTREGA_V1 = API + "/v1/entregas";
    public static final String ENTREGA_ID = ENTREGA_V1 + "/{entregaId}";
    public static final String ENTREGA_VERIFICAR_PAGAMENTO = ENTREGA_ID + "/verificar-pagamento";
    public static final String ENTREGA_CONFIRMAR = ENTREGA_ID + "/confirmar-entrega";

    public static final String PEDIDO_V1 = API + "/v1/pedidos";
    public static final String PEDIDO_ID = PEDIDO_V1 + "/{pedidoId}";
}
