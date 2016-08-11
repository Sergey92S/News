package com.revotech.news.tiles.factory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.context.TilesRequestContextFactory;
import org.apache.tiles.definition.DefinitionsFactoryException;
import org.apache.tiles.factory.BasicTilesContainerFactory;

public class TilesContainerFactory extends BasicTilesContainerFactory {
    // RESOURCE PATH
    private static String RESOURCE_PATH = "/WEB-INF/tiles-defs.xml";

    // MESSAGES
    private static String EXCEPTION_MESSAGE = "Cannot load definition URLs";

    public TilesContainerFactory() {
    }

    protected List<URL> getSourceURLs(TilesApplicationContext applicationContext, TilesRequestContextFactory contextFactory) {
        ArrayList urls = new ArrayList();

        try {
            urls.add(applicationContext.getResource(RESOURCE_PATH));
            return urls;
        } catch (IOException var5) {
            throw new DefinitionsFactoryException(EXCEPTION_MESSAGE, var5);
        }
    }
}
