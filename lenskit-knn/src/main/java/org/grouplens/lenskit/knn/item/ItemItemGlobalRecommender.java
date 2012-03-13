/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2011 Regents of the University of Minnesota
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
/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2011 Regents of the University of Minnesota
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

import it.unimi.dsi.fastutil.longs.LongSet;

import org.grouplens.lenskit.core.ScoreBasedGlobalItemRecommender;
import org.grouplens.lenskit.data.dao.DataAccessObject;

/**
 * Global recommendation with item-item CF.
 * 
 * @author Shuo Chang <schang@cs.umn.edu>
 * 
 */
public class ItemItemGlobalRecommender extends ScoreBasedGlobalItemRecommender {
	protected final ItemItemModelBackedGlobalScorer scorer;

	public ItemItemGlobalRecommender(DataAccessObject dao,
                                     ItemItemModelBackedGlobalScorer scorer) {
		super(dao, scorer);
		this.scorer = scorer;
	}
	
    @Override
    public LongSet getPredictableItems(LongSet items) {
        return scorer.getScoreableItems(items);
    }

}