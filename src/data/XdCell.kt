package org.yttr.vile.data

import jetbrains.exodus.entitystore.Entity
import kotlinx.dnq.XdEntity
import kotlinx.dnq.XdNaturalEntityType
import kotlinx.dnq.xdLink0_N

/**
 * Cells are the basic building blocks of bodies formed by transformations.
 */
class XdCell(entity: Entity) : XdEntity(entity) {
    companion object : XdNaturalEntityType<XdCell>()

    val tags by xdLink0_N(XdTag)
}
