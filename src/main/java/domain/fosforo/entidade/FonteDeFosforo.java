package domain.fosforo.entidade;

import java.util.ArrayList;
import java.util.Arrays;

public enum FonteDeFosforo {
    SUPERFOSFATO_SIMPLES{
        public ArrayList<Double> valor(){
            //fosforo, enxofre, magnesio, calcio, nitrogenio
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{18.0, 0.1, 0.0, 0.28, 0.0}));
            return nutrientes;
        }
    },
    SUPERFOSFATO_TRIPLO{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{41.0, 0.00, 0.0, 0.20, 0.0}));
            return nutrientes;
        }
    },
    MAP{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{48.0, 0.00, 0.0, 0.0, 0.09}));
            return nutrientes;
        }
    },
    DAP{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{45.0, 0.00, 0.0, 0.0, 0.16}));
            return nutrientes;
        }
    },
    YOORIN{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{18.0, 0.00, 0.15, 0.28, 0.0}));
            return nutrientes;
        }
    },

    FOSFATO_ARAD{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{33.0, 0.00, 0.0, 0.52, 0.0}));
            return nutrientes;
        }
    },
    FOSFATO_GAFSA{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{29.0, 0.00, 0.0, 0.52, 0.0}));
            return nutrientes;
        }
    },
    FOSFATO_DAOUI{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{32.0, 0.00, 0.0, 0.45, 0.0}));
            return nutrientes;
        }
    },
    FOSF_PATOS_MINAS{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{24.0, 0.01, 0.0, 0.28, 0.0}));
            return nutrientes;
        }
    },
    ESCORIA_DE_THOMAS{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{18.5, 0.01, 0.0, 0.44, 0.0}));
            return nutrientes;
        }
    },
    ACIDO_FOSFORICO{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{52.0, 0.0, 0.0, 0.0, 0.0}));
            return nutrientes;
        }
    },
    MULTIF_MAGNESIANO{
        public ArrayList<Double> valor(){
            ArrayList<Double> nutrientes = new ArrayList(Arrays.asList(new Double[]{18.0, 0.11, 0.0, 0.18, 0.0}));
            return nutrientes;
        }
    };

    public abstract ArrayList<Double> valor();
}