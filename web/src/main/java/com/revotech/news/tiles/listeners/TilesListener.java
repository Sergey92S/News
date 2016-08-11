package com.revotech.news.tiles.listeners;

/**
 * Created by Revotech on 21.06.2016.
 */
import com.revotech.news.tiles.factory.TilesContainerFactory;
import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;

public class TilesListener extends AbstractTilesListener {

    @Override
    protected TilesInitializer createTilesInitializer() {
        return new TestTilesListenerInitializer();
    }
    private static class TestTilesListenerInitializer extends AbstractTilesInitializer {
        @Override
        protected AbstractTilesContainerFactory createContainerFactory(
                TilesApplicationContext context) {
            return new TilesContainerFactory();
        }
    }
}
