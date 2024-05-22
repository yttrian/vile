package org.yttr.vile.data

import arrow.fx.coroutines.Resource
import arrow.fx.coroutines.autoCloseable
import jetbrains.exodus.database.TransientEntityStore
import kotlinx.dnq.XdModel
import kotlinx.dnq.store.container.StaticStoreContainer
import kotlinx.dnq.util.initMetaData
import java.io.File

/**
 * Initialize the Xodus entity store.
 */
object Xodus {
    // He's literally just a lizard-folk from a D&D campaign that was originally going to be the name for this project.
    private const val DEFAULT_ENTITY_STORE_NAME = "chiukkozazk"
    const val DEFAULT_DATABASE_FOLDER = "./vile"

    init {
        XdModel.registerNodes(XdBoard, XdCell, XdTag)
    }

    /**
     * Create a [TransientEntityStore] resource.
     * The store is not initialized/opened until the resource is bound to a resourceScope.
     */
    fun createStoreResource(
        database: String = DEFAULT_DATABASE_FOLDER,
        entityStoreName: String = DEFAULT_ENTITY_STORE_NAME
    ): Resource<TransientEntityStore> = autoCloseable {
        StaticStoreContainer.init(
            dbFolder = File(database),
            entityStoreName = entityStoreName
        ).also { initMetaData(XdModel.hierarchy, it) }
    }
}
