/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2013 Regents of the University of Minnesota and contributors
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.knn.item;

import org.grouplens.lenskit.ItemScorer;
import org.grouplens.lenskit.basic.TopNItemRecommender;
import org.grouplens.lenskit.data.dao.DataAccessObject;

import javax.inject.Inject;

/**
 * Recommend items using item-item collaborative filtering.
 *
 * @deprecated Just use {@link org.grouplens.lenskit.basic.TopNItemRecommender} instead.
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
@Deprecated
public class ItemItemRecommender extends TopNItemRecommender {
    /**
     * Construct a new item-item recommender from a scorer.
     *
     * @param scorer The scorer to use.
     */
    @Inject
    public ItemItemRecommender(DataAccessObject dao, ItemScorer scorer) {
        super(dao, scorer);
    }
}
