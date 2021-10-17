package Patterns;

import java.math.BigDecimal;

public class Strategy_treino {

    public static void main(String[] args) {

        TipoPagamento tipoPagamentoCredito = new TipoPagamento(new BigDecimal("100"), 1);
        TipoPagamento tipoPagamentoDebito = new TipoPagamento(new BigDecimal("100"), 2);

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.pagar(tipoPagamentoCredito);

    }

    static class TipoPagamento{
        BigDecimal bigDecimal;
        int tipoPagamento;

        public TipoPagamento(BigDecimal bigDecimal, int tipoPagamento) {
            this.bigDecimal = bigDecimal;
            this.tipoPagamento = tipoPagamento;
        }
    }


    static class CartaoDeCredito implements MeioDePagamento {

        TipoPagamento tipoPagamento;

        public void pagar(TipoPagamento tipoPagamento) {
            System.out.println("pagamento de "+tipoPagamento.tipoPagamento);
            System.out.println("valor de "+tipoPagamento.bigDecimal);
        }
    }

    interface MeioDePagamento{
        void pagar(TipoPagamento tipoPagamento);
    }


}
