package com.rocklobstre.kasko.domain.interactors.taglist;

import com.rocklobstre.kasko.data.repositories.TagListRepository;
import com.rocklobstre.kasko.data.repositories.UserRepository;
import com.rocklobstre.kasko.domain.interactors.Params;
import com.rocklobstre.kasko.domain.interactors.base.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Implementation of {@link BaseUseCase} that represents a UseCase/Interactor
 */
public class GetTagListUseCase extends BaseUseCase {

  private final TagListRepository tagListRepository;

  @Inject
  public GetTagListUseCase(TagListRepository tagListRepository) {
    this.tagListRepository = tagListRepository;
  }

  @Override public Observable getObservable(Params params) {
    return this.tagListRepository.getTagList();
  }
}