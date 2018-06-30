package com.rocklobstre.kasko.data.entities.mappers;

import com.rocklobstre.kasko.data.entities.TaskPriorityEntity;
import com.rocklobstre.kasko.domain.models.TaskPriorityModel;

/**
 * Created by Matin on 23/02/2017.
 */
public class TaskPriorityMapper {

    public static TaskPriorityModel transform(TaskPriorityEntity taskPriorityEntity) {
        TaskPriorityModel taskPriorityModel = null;
        if (taskPriorityEntity != null) {
            taskPriorityModel = new TaskPriorityModel(taskPriorityEntity.getId(),
                    taskPriorityEntity.getLabel());
            taskPriorityModel.setId(taskPriorityEntity.getId());
            taskPriorityModel.setLabel(taskPriorityEntity.getLabel());
        }

        return taskPriorityModel;
    }
}
