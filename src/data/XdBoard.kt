package org.yttr.vile.data

import jetbrains.exodus.entitystore.Entity
import kotlinx.dnq.XdEntity
import kotlinx.dnq.XdNaturalEntityType
import kotlinx.dnq.xdLink0_1

/**
 * A board is a transformation of [XdCell] into lists based on [XdTag]'s they have.
 */
class XdBoard(entity: Entity) : XdEntity(entity) {
    companion object : XdNaturalEntityType<XdBoard>()

    val tags by xdLink0_1(XdTag)
}
