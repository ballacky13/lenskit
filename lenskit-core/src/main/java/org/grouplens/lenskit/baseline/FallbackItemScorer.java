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
package org.grouplens.lenskit.baseline;

import org.grouplens.lenskit.ItemScorer;
import org.grouplens.lenskit.basic.AbstractItemScorer;
import org.grouplens.lenskit.vectors.MutableSparseVector;

import javax.annotation.Nonnull;
import javax.inject.Inject;

/**
 * Item scorer that combines a primary scorer with a baseline.  This scorer is comprised of two
 * other scorers, a primary scorer and a baseline scorer.  It first scores items using the primary
 * scorer, and then consults the baseline scorer for any items that the primary scorer could not
 * score.
 *
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
public class FallbackItemScorer extends AbstractItemScorer {
    private final ItemScorer primaryScorer;
    private final ItemScorer baselineScorer;

    @Inject
    public FallbackItemScorer(@PrimaryScorer ItemScorer primary,
                              @BaselineScorer ItemScorer baseline) {
        primaryScorer = primary;
        baselineScorer = baseline;
    }

    @Override
    public void score(long user, @Nonnull MutableSparseVector output) {
        primaryScorer.score(user, output);
        if (output.size() != output.keyDomain().size()) {
            MutableSparseVector blpreds = MutableSparseVector.create(output.unsetKeySet());
            baselineScorer.score(user, blpreds);
            output.set(blpreds);
        }
    }

    /**
     * Get the primary scorer from this item scorer.
     * @return The scorer's primary scorer.
     * @see PrimaryScorer
     */
    @Nonnull
    public ItemScorer getPrimaryScorer() {
        return primaryScorer;
    }

    /**
     * Get the baseline scorer from this item scorer.
     * @return The scorer's baseline scorer.
     * @see BaselineScorer
     */
    @Nonnull
    public ItemScorer getBaselineScorer() {
        return baselineScorer;
    }
}
