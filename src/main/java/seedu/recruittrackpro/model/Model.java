package seedu.recruittrackpro.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.recruittrackpro.commons.core.GuiSettings;
import seedu.recruittrackpro.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' RecruitTrackPro file path.
     */
    Path getRecruitTrackProFilePath();

    /**
     * Sets the user prefs' RecruitTrackPro file path.
     */
    void setRecruitTrackProFilePath(Path recruitTrackProFilePath);

    /**
     * Replaces RecruitTrackPro data with the data in {@code recruitTrackPro}.
     */
    void setRecruitTrackPro(ReadOnlyRecruitTrackPro recruitTrackPro);

    /**
     * Returns the RecruitTrackPro
     */
    ReadOnlyRecruitTrackPro getRecruitTrackPro();

    /**
     * Returns true if a person with the same identity as {@code person} exists in RecruitTrackPro.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in RecruitTrackPro.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in RecruitTrackPro.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in RecruitTrackPro.
     * The person identity of {@code editedPerson} must not be the same as another existing person in RecruitTrackPro.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Returns an unmodifiable view of the filtered person list
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Switches current sorting order between ascending and descending.
     */
    void switchRecruitTrackProSorting();

    /**
     * Returns the current sorting order, {@code true} if ascending, {@code false} if descending.
     */
    boolean isRecruitTrackProAscending();
}
