import java.util.Spliterator;

public class SpellingWizard implements AutoCloseable {
    private boolean mouth_opened = false;

    public void open_mouth() {
        mouth_opened = true;
    }

    @Override
    public void close() {
        mouth_opened = false;
    }

    public void put_spell_safe(String spell) {
        if (spell == null) {
            throw new IllegalArgumentException("Can't put spell without spelling!");
        }
        if (!mouth_opened) {
            throw new IllegalStateException("Can't spell with closed mouth!");
        }
        try {
            put_spell(spell);
        } catch (SpellBannedException ex) {
            System.out.println("Illegal spell, yong wizard");
            System.out.println("code = " + ex.getCode());
            System.out.println("description = " + ex.getDescription());
            System.out.println("message = " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void put_spell(String spell) throws SpellBannedException {
        if (spell.equals("Avada Kedavra")) {
            throw new SpellBannedException(1, "killing curse", "Use of unforgivable course forbidden");
        }
        if (spell.equals("Crucio")) {
            throw new SpellBannedException(2, "cruciatus curse", "Use of unforgivable course forbidden");
        }
        if (spell.equals("Imperio")) {
            throw new SpellBannedException(3, "imperius curse", "Use of unforgivable course forbidden");
        }
        System.out.println("Wizard waves his magic wound and tell " + spell);
    }
}
