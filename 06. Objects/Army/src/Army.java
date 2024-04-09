class Army {

    public static void createArmy() {
        // Create all objects here
        String[] numes = {"Alex", "Ion", "Vadic", "Bob", "Bruk"};
        for (int i = 0; i < 5; i++) {
            Unit unit = new Unit(numes[i]);
        }
        for (int i = 0; i < 3; i++) {
            Knight knight = new Knight(numes[i]);
        }
        General general = new General("Bob");
        Doctor doctor = new Doctor("Aracs");
    }

    // Don't change the code below
    public static void main(String[] args) {

        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}