package org.yttr.vile

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.optional
import org.yttr.vile.data.Xodus

/**
 * Command line argument parser for vile
 */
class VileArgParser : ArgParser("vile") {
    val database by argument(
        type = ArgType.String,
        fullName = "database",
        description = "The database folder to use.",
    ).optional().default(Xodus.DEFAULT_DATABASE_FOLDER)
}
