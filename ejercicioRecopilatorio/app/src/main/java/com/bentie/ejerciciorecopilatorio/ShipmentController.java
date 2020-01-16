package com.bentie.ejerciciorecopilatorio;

import com.bentie.ejerciciorecopilatorio.model.Shipment;

public class ShipmentController {

    private static final float LIGHT_COST = 1f;
    private static final float MEDIUM_COST = 1.5f;
    private static final float HEAVY_COST = 2f;

    private final Shipment shipment;

    public ShipmentController(Shipment shipment){
        this.shipment = shipment;

    }

    public String getFare(){
        if(shipment.isUrgent())
            return "Urgente";
        return "Normal";
    }

    public String getDecorations(){
        String decorations = "";

        if(shipment.isGift() && shipment.hasCard())
            return "Con caja regalo y dedicatoria.";

        if(shipment.isGift())
            decorations += "Con caja de regalo.";
        else if(shipment.hasCard())
            decorations += "Con tarjeta dedicada.";
        else if(!shipment.hasCard() && !shipment.isGift())
            decorations += "Sin extras.";

        return decorations;
    }

    public float getCost(){
        float cost = 0;
        cost += shipment.getZone().getPrice();
        switch(shipment.getWeight()){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                cost += shipment.getWeight() * LIGHT_COST;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                cost += shipment.getWeight() * MEDIUM_COST;
                break;
            default:
                cost += shipment.getWeight() * HEAVY_COST;
            break;
        }

        if(shipment.isUrgent()) cost *= 1.3f;

        return cost;
    }

}
