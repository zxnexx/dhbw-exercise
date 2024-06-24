package de.dhbw.programming.secondsemester.threads.trafficlights;

class TrafficLight {
    private TrafficLightPhase currentPhase;

    public TrafficLight() {
        currentPhase = TrafficLightPhase.RED;
    }

    public void start() {
        while (true) {
            showPhase(currentPhase);
            try {
                Thread.sleep(currentPhase.getDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentPhase = currentPhase.getNext();
        }
    }

    private void showPhase(TrafficLightPhase phase) {
        System.out.println("Phase: " + phase);
        System.out.println("Red: " + (phase.isRed() ? "On" : "Off"));
        System.out.println("Yellow: " + (phase.isYellow() ? "On" : "Off"));
        System.out.println("Green: " + (phase.isGreen() ? "On" : "Off"));
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();
    }
}
