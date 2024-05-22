package org.yttr.vile

import arrow.fx.coroutines.resourceScope
import org.yttr.vile.data.Xodus

suspend fun main(args: Array<String>) {
    resourceScope {
        val parser = VileArgParser()
        parser.parse(args)

        Xodus.createStoreResource(parser.database).bind()
    }
}
