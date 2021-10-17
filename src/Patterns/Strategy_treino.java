package Patterns;

import java.math.BigDecimal;

public class Strategy_treino {

    public static void main(String[] args) {

        TipoPagamento tipoPagamentoCredito = new TipoPagamento(new BigDecimal("100"), enumPagamento.CREDITO);

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.pagar(tipoPagamentoCredito);

    }

    static class TipoPagamento{
        BigDecimal bigDecimal;
        enumPagamento tipoPagamento;

        public TipoPagamento(BigDecimal bigDecimal, enumPagamento tipoPagamento) {
            this.bigDecimal = bigDecimal;
            this.tipoPagamento = tipoPagamento;
        }
    }

    static class CartaoDeDebito implements MeioDePagamento {
        public void pagar(TipoPagamento tipoPagamento) {
            System.out.println("pagamento de "+tipoPagamento.tipoPagamento=="1"? enumPagamento.CREDITO: enumPagamento.CREDITO);
            System.out.println("valor de "+tipoPagamento.bigDecimal);
        }
    }

    static class CartaoDeCredito implements MeioDePagamento {
        public void pagar(TipoPagamento tipoPagamento) {
            System.out.println("pagamento de "+tipoPagamento.tipoPagamento=="1"? enumPagamento.CREDITO: enumPagamento.CREDITO);
            System.out.println("valor de "+tipoPagamento.bigDecimal);
        }
    }

    interface MeioDePagamento{
        void pagar(TipoPagamento tipoPagamento);
    }

    public enum enumPagamento {
        CREDITO ,
        DEBITO  ;
    }

}
