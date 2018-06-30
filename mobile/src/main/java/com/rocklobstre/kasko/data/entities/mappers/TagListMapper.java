package com.rocklobstre.kasko.data.entities.mappers;

import com.rocklobstre.kasko.data.entities.TagListEntity;
import com.rocklobstre.kasko.domain.models.TagListModel;

/**
 * Created by Matin on 23/02/2017.
 */
public class TagListMapper {

    public static TagListModel transform(TagListEntity tagListEntity) {
        TagListModel tagListModel = new TagListModel();
        if (tagListEntity != null) {
            tagListModel.setTags(tagListEntity.getTags());
        }

        return tagListModel;
    }
}
