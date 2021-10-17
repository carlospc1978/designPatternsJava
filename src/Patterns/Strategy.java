package Patterns;


import java.math.BigDecimal;
import java.security.PublicKey;

public class Strategy {

    // estrategia ... interface quase sempre
    // estrategia completa
    // contexto de quem utiliza a estrategia

    public static void main(String[] args) {
        System.out.println("Teste");

        Compra compra = new Compra(BigDecimal.TEN);
        compra.processarCompra(new PagamentoCartaoDeDebito());
        compra.processarCompra(new PagamentoCartaoDeCredito());

    }


    static class Compra{

        BigDecimal bigDecimal;

        public Compra(BigDecimal valor){
            this.bigDecimal =valor.multiply(BigDecimal.TEN);
        }

        void processarCompra (EstrategiaDePagamento estrategiaDePagamento){
            estrategiaDePagamento.Pagar(bigDecimal);
        }

    }

    interface EstrategiaDePagamento{
        void Pagar(BigDecimal bigDecimal);
    }

    static class PagamentoCartaoDeDebito implements EstrategiaDePagamento{
        public void Pagar(BigDecimal bigDecimal) {
            System.out.println("pago no debito "+bigDecimal.multiply(new BigDecimal("0.90")));
        }
    }

    static class PagamentoCartaoDeCredito implements EstrategiaDePagamento{
        public void Pagar(BigDecimal bigDecimal){
            System.out.println("pago no credito "+bigDecimal);
        }
    }


}