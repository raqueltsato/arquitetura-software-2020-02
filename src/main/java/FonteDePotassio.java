public enum FonteDePotassio {

    CLORETO_DE_POTASSIO {
        public double valor() {
            return 58.0;
        }
    },
    SULFATO_DE_POTASSIO {
        public double valor() {
            return 52.0;
        }

    },
    SULFATO_DE_POTASSIO_E_MAGNESIO {
        public double valor() {
            return 22.0;
        }

    },
    NITRATO_DE_POTASSIO {
        public double valor() {
            return 44.0;
        }
    };

    public abstract double valor();
}
