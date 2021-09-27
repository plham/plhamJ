package plham.core.main.glb;

import java.util.ArrayList;
import java.util.List;

import apgas.Place;
import handist.collections.dist.TeamedPlaceGroup;
import handist.collections.glb.lifeline.Lifeline;

/**
 * Symmetric doubly-linked circular loop between places [1..n-1]. 
 * Place 0 remains excluded from the lifeline network.
 * @author Patrick Finnerty
 *
 */
public class PlhamLifeline extends Lifeline {

    public PlhamLifeline(TeamedPlaceGroup pg) {
        super(pg);
        if (pg != TeamedPlaceGroup.getWorld()) {
            throw new RuntimeException("This lifeline strategy is not meant to be used with a place group different than world");
        }
        
        // For convenience, remove place(0) from the sorted list of places
        sortedListOfPlaces.remove(0);
    }

    @Override
    public List<Place> lifeline(Place p) {
        ArrayList<Place> lifelines = new ArrayList<>();

        // Only compute lifelines if place if not place(0)
        if (p.id != 0) {
            int currentIndex = sortedListOfPlaces.indexOf(p);
            int size = sortedListOfPlaces.size();
            int left = currentIndex - 1 < 0 ? size - 1 : currentIndex - 1;
            int right = currentIndex + 1 >= size ? 0 : currentIndex + 1;
            
            lifelines.add(sortedListOfPlaces.get(left));
            lifelines.add(sortedListOfPlaces.get(right));
        }
        return lifelines;
    }

    /**
     * As the lifeline scheme implemented here is  (if A is a lifeline of B, then B is a lifeline of A), we delegate to {@link #lifeline(Place)} to avoid code duplication.
     */
    @Override
    public List<Place> reverseLifeline(Place p) {
        return lifeline(p);
    }

}
