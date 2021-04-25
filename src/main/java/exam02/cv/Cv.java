package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skills) {
        for (String s: skills) {
            String sk = s.substring(0, s.length() - 4);
            int lev = Integer.parseInt(s.substring(s.length() - 2, s.length() - 1));
            this.skills.add(new Skill(sk, lev));
        }

    }

    public int findSkillLevelByName(String name) {
        for (Skill sk: skills) {
            if (sk.getName().equals(name)) {
                return sk.getLevel();
            }
        }
        throw new SkillNotFoundException("Nincs ilyen skill");
    }
}
