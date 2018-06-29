package com.rocklobstre.kasko.data.repositories;

import com.rocklobstre.kasko.data.entities.BucketEntity;
import com.rocklobstre.kasko.data.entities.mappers.BucketMapper;
import com.rocklobstre.kasko.data.repositories.datasource.BucketDataSourceRemote;
import com.rocklobstre.kasko.domain.models.BucketModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * The repository is in charge of getting the data from the DataSource,
 * It will also map data from entity to model
 * Created by remychantenay on 23/02/2017.
 */
@Singleton
public class BucketRepository {

    private final BucketDataSourceRemote bucketDataSourceRemote;

    @Inject
    public BucketRepository(BucketDataSourceRemote bucketDataSourceRemote) {
        this.bucketDataSourceRemote = bucketDataSourceRemote;
    }

    public Observable<BucketModel> getBucket() {

        return bucketDataSourceRemote.getBucket().map(new Function<BucketEntity, BucketModel>() {
            @Override
            public BucketModel apply(BucketEntity bucketEntity) throws Exception {
                return BucketMapper.transform(bucketEntity);
            }
        });
    }
}
