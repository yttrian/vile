package org.yttr.vile.data

import jetbrains.exodus.entitystore.Entity
import kotlinx.dnq.XdEntity
import kotlinx.dnq.XdNaturalEntityType
import kotlinx.dnq.link.OnDeletePolicy
import kotlinx.dnq.xdLink0_N
import kotlinx.dnq.xdRequiredStringProp

/**
 * Represents a tag on a [XdCell]
 */
class XdTag(entity: Entity) : XdEntity(entity) {
    companion object : XdNaturalEntityType<XdTag>()

    var name by xdRequiredStringProp()
    val cells by xdLink0_N(XdCell, onTargetDelete = OnDeletePolicy.CLEAR)
}
