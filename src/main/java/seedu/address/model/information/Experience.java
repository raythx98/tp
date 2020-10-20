package seedu.address.model.information;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's experience in years.
 * Guarantees: immutable; is valid as declared in {@link #isValidExperience(String)}
 */
public class Experience {

    public static final String MESSAGE_CONSTRAINTS = "Experience in years has to be an unsigned (non-negative) number.";

    public final double experienceInYears;
    public final String value;

    /**
     * Constructs an {@code Experience}.
     *
     * @param experience A string representing a valid number of years of experience.
     */
    public Experience(String experience) {
        requireNonNull(experience);
        checkArgument(isValidExperience(experience), MESSAGE_CONSTRAINTS);
        value = experience;
        experienceInYears = Double.parseDouble(experience);
    }

    /**
     * Returns if a given String represents valid number of years of experience.
     */
    public static boolean isValidExperience(String test) {
        double experience;
        try {
            experience = Double.parseDouble(test);
        } catch (NumberFormatException exception) {
            return false;
        }
        return experience >= 0;
    }

    @Override
    public String toString() {
        return experienceInYears + "";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Experience // instanceof handles nulls
                && experienceInYears == ((Experience) other).experienceInYears); // state check
    }

    @Override
    public int hashCode() {
        return Double.valueOf(experienceInYears).hashCode();
    }

}
