package seedu.recruittrackpro.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.recruittrackpro.commons.core.LogsCenter;
import seedu.recruittrackpro.commons.exceptions.DataLoadingException;
import seedu.recruittrackpro.model.ReadOnlyRecruitTrackPro;
import seedu.recruittrackpro.model.ReadOnlyUserPrefs;
import seedu.recruittrackpro.model.UserPrefs;

/**
 * Manages storage of RecruitTrackPro data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private RecruitTrackProStorage recruitTrackProStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code RecruitTrackProStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(RecruitTrackProStorage recruitTrackProStorage, UserPrefsStorage userPrefsStorage) {
        this.recruitTrackProStorage = recruitTrackProStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ RecruitTrackPro methods ==============================

    @Override
    public Path getRecruitTrackProFilePath() {
        return recruitTrackProStorage.getRecruitTrackProFilePath();
    }

    @Override
    public Optional<ReadOnlyRecruitTrackPro> readRecruitTrackPro() throws DataLoadingException {
        return readRecruitTrackPro(recruitTrackProStorage.getRecruitTrackProFilePath());
    }

    @Override
    public Optional<ReadOnlyRecruitTrackPro> readRecruitTrackPro(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return recruitTrackProStorage.readRecruitTrackPro(filePath);
    }

    @Override
    public void saveRecruitTrackPro(ReadOnlyRecruitTrackPro recruitTrackPro) throws IOException {
        saveRecruitTrackPro(recruitTrackPro, recruitTrackProStorage.getRecruitTrackProFilePath());
    }

    @Override
    public void saveRecruitTrackPro(ReadOnlyRecruitTrackPro recruitTrackPro, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        recruitTrackProStorage.saveRecruitTrackPro(recruitTrackPro, filePath);
    }

}
