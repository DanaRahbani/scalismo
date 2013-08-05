package smptk
package io

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.File
import scala.util.Success
import scala.util.Failure
import geometry._
import smptk.image.Utils
import smptk.mesh.{TriangleMesh}

class StatismoIOTest extends FunSpec with ShouldMatchers {

    smptk.initialize()
  
  describe("a Statismo Mesh MOdel") {
    it("can be read") {
      val statismoFile = new File("/tmp/facemodel.h5")
      val maybeModel = StatismoIO.readStatismoMeshModel(statismoFile)
      maybeModel match {
        case Success(model) => {
          val refMesh = model.mesh
          val meshPts = refMesh.points
          // TODO fix this test
        }
        case Failure(e) => {
          println(e)
          e.printStackTrace()
          maybeModel.isSuccess should be(true)
        }
      }
    }
  }
}