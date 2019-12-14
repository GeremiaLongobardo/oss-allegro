/*
 * Copyright 2019 Symphony Communication Services, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.symphony.oss.allegro.api.request;

import java.util.HashSet;
import java.util.Set;

import org.symphonyoss.s2.common.fault.FaultAccumulator;
import org.symphonyoss.s2.common.fluent.BaseAbstractBuilder;
import org.symphonyoss.s2.common.hash.Hash;

import com.google.common.collect.ImmutableSet;

/**
 * Request object for UpsertFeed.
 * 
 * @author Bruce Skingle
 *
 */
public class UpsertFeedRequest
{
  private final String             name_;
  private final ImmutableSet<Hash> partitionHashes_;
  
  UpsertFeedRequest(AbstractBuilder<?,?> builder)
  {
    name_             = builder.name_;
    partitionHashes_  = ImmutableSet.copyOf(builder.partitionHashes_);
  }
  
  /**
   * 
   * @return The name of the partition.
   */
  public String getName()
  {
    return name_;
  }
  
  /**
   * 
   * @return The allowable ThreadIds for this partition.
   */
  public Set<Hash> getPartitionHashes()
  {
    return partitionHashes_;
  }
  
  /**
   * Builder.
   * 
   * @author Bruce Skingle
   *
   */
  public static class Builder extends AbstractBuilder<Builder, UpsertFeedRequest>
  {
    /**
     * Constructor.
     */
    public Builder()
    {
      super(Builder.class);
    }

    @Override
    protected UpsertFeedRequest construct()
    {
      return new UpsertFeedRequest(this);
    }
  }

  /**
   * AbstractBuilder.
   * 
   * @author Bruce Skingle
   *
   * @param <T> Concrete type of the builder for fluent methods.
   * @param <B> Concrete type of the built object for fluent methods.
   */
  public static abstract class AbstractBuilder<T extends AbstractBuilder<T,B>, B extends UpsertFeedRequest> extends BaseAbstractBuilder<T,B>
  {
    protected String        name_;
    protected Set<Hash>     partitionHashes_ = new HashSet<>();
    
    AbstractBuilder(Class<T> type)
    {
      super(type);
    }
    
    /**
     * Set the name of the partition.
     * 
     * @param name The content type for the sequence.
     * 
     * @return This (fluent method)
     */
    public T withName(String name)
    {
      name_ = name;
      
      return self();
    }

    /**
     * Add the given partition hashes to the set of partitions o be subscribed to.
     * 
     * @param partitionHashes partition hashes to the set of partitions o be subscribed to.
     * 
     * @return This (fluent method)
     */
    public T withPartitionHashes(Hash ...partitionHashes)
    {
      for(Hash partitionHash : partitionHashes)
        partitionHashes_.add(partitionHash);
      
      return self();
    }
    
    @Override
    protected void validate(FaultAccumulator faultAccumulator)
    {
      super.validate(faultAccumulator);
      
      faultAccumulator.checkNotNull(name_, "Name");
    }
  }
}