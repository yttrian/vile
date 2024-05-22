package org.yttr.vile.data

import arrow.fx.coroutines.resourceScope
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class XodusTest {
    @Test
    fun `createStoreResource when bound opens a store`() {
        runBlocking {
            val leakedStore = resourceScope {
                val store = Xodus.createStoreResource(entityStoreName = "test").bind()
                assertTrue("Store must be open when bound!") { store.isOpen }
                store
            }
            assertFalse("Store must be closed when resourceScope completes!") { leakedStore.isOpen }
        }
    }
}
