package br.com.comercio.model;

    public class Vendedor {
        private int numero;
        private String nome;
        private double salarioFixo;
        private double comissoes;

        public Vendedor(int numero, String nome, double salarioFixo) {
            this.numero = numero;
            this.nome = nome;
            this.salarioFixo = salarioFixo;
            this.comissoes = 0.0;
        }

        public void adicionarComissao(double valorComissao) {
            this.comissoes += valorComissao;
        }

        public int getNumero() {
            return numero;
        }

        public String getNome() {
            return nome;
        }

        public double getSalarioFixo() {
            return salarioFixo;
        }

        public double getComissoes() {
            return comissoes;
        }

        public double getSalarioTotal() {
            return this.salarioFixo + this.comissoes;
        }

        @Override
        public String toString() {
            return "Informações do vendedr: numero=" + numero + ", nome=" + nome + ", salarioFixo=R$" + salarioFixo + ", comissoes=R$" + comissoes + "]";
        }
    }

