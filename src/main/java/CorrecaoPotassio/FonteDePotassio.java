package CorrecaoPotassio;

import java.util.ArrayList;
import java.util.Arrays;

public enum FonteDePotassio {

    CLORETO_DE_POTASSIO {
        public ArrayList<Double> valor() {
            //potassio, enxofre, magnesio
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{58.0, 0.0, 0.0}));
            return nutrientes;
            //return 58.0;
        }
    },
    SULFATO_DE_POTASSIO {
        public ArrayList<Double> valor() {
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{52.0, 0.17, 0.0}));
            return nutrientes;
            //return 52.0;
        }

    },
    SULFATO_DE_POTASSIO_E_MAGNESIO {
        public ArrayList<Double> valor() {
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{22.0, 0.22, 0.18}));
            return nutrientes;
            //return 22.0;
        }

    },
    NITRATO_DE_POTASSIO {
        public ArrayList<Double> valor() {
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{44.0, 0.0, 0.0}));
            return nutrientes;
            //return 44.0;
        }
    };

    public abstract ArrayList<Double> valor();
}
