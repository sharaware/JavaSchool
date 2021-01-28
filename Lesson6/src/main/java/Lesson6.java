public class Lesson6 {
    public static void main(String[] args) {
        SpellingWizard wizard = new SpellingWizard();
        System.out.println("================== Wizard =================");
        try {
            wizard.put_spell_safe("Lumus");
        } catch(IllegalArgumentException | IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("================== Wizard2 ================");
        try (SpellingWizard wizard2 = new SpellingWizard()) {
            wizard2.open_mouth();
            wizard2.put_spell_safe("Lumus");
            wizard2.put_spell_safe("Crucio");
            wizard2.put_spell_safe(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
