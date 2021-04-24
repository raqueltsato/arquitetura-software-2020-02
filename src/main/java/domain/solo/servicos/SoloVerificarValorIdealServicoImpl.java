package domain.solo.servicos;

import domain.solo.entidade.Solo;
import domain.solo.entidade.SoloTextura;

public class SoloVerificarValorIdealServicoImpl {

    public static Solo verificarValorIdeal(final SoloTextura textura) {
            Solo ideal = null;
            if (textura.equals(SoloTextura.CODIG0_ARGILOSO)) {
                ideal = new Solo(SoloTextura.CODIG0_ARGILOSO, 9, 0.35, 6.0, 1.5, 9.0, 0, 0);
            } else if(textura.equals(SoloTextura.CODIGO_MEDIA)){
                ideal = new Solo(SoloTextura.CODIGO_MEDIA, 9, 0.25, 4.0, 1.0, 6.0, 0, 0);
            }
            return ideal;
        }

    }

