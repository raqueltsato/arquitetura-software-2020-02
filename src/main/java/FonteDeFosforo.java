public enum FonteDeFosforo {
    SUPERFOSFATO_SIMPLES{
        public double valor(){
            return 18.0;
        }
    },
    SUPERFOSFATO_TRIPLO{
        public double valor(){
            return 41.0;
        }
    },
    MAP{
        public double valor(){
            return 48.0;
        }
    },
    DAP{
        public double valor(){
            return 45.0;
        }
    },
    YOORIN{
        public double valor(){
            return 18.0;
        }
    },

    FOSFATO_ARAD{
        public double valor(){
            return 33.0;
        }
    },
    FOSFATO_GAFSA{
        public double valor(){
            return 29.0;
        }
    },
    FOSFATO_DAOUI{
        public double valor(){
            return 32.0;
        }
    },
    FOSF_PATOS_MINAS{
        public double valor(){
            return 24.0;
        }
    },
    ESCORIA_DE_THOMAS{
        public double valor(){
            return 18.5;
        }
    },
    ACIDO_FOSFORICO{
        public double valor(){
            return 52.0;
        }
    },
    MULTIF_MAGNESIANO{
        public double valor(){
            return 18.0;
        }
    };

    public abstract double valor();
}
