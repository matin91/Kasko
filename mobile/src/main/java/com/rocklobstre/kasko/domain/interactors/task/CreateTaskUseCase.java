package com.rocklobstre.kasko.domain.interactors.task;

import com.rocklobstre.kasko.data.repositories.TagListRepository;
import com.rocklobstre.kasko.data.repositories.TaskRepository;
import com.rocklobstre.kasko.domain.interactors.Params;
import com.rocklobstre.kasko.domain.interactors.base.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Implementation of {@link BaseUseCase} that represents a UseCase/Interactor
 */
public class CreateTaskUseCase extends BaseUseCase {

  public final static String PARAMS_KEY_TITLE = "title";
  public final static String PARAMS_KEY_DEADLINE = "deadline";
  public final static String PARAMS_KEY_DEADLINE_MS = "deadline_ms";
  public final static String PARAMS_KEY_TAG = "tag";
  public final static String PARAMS_KEY_PRIORITY_ID = "priority_id";
  public final static String PARAMS_KEY_PRIORITY_LABEL = "priority_label";

  private final TaskRepository taskRepository;

  @Inject
  public CreateTaskUseCase(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override public Observable getObservable(Params params) {
    return this.taskRepository.createTask(params.getString(PARAMS_KEY_TITLE, "Title"),
            params.getString(PARAMS_KEY_DEADLINE, "Mon Jun 27 09:52:29 GMT+01:00 2016"),
            params.getLong(PARAMS_KEY_DEADLINE_MS, 1L),
            params.getString(PARAMS_KEY_TAG, "Tag"),
            params.getInt(PARAMS_KEY_PRIORITY_ID, 0),
            params.getString(PARAMS_KEY_PRIORITY_LABEL, "Label"));
  }
}